package com.yelinaung.luluaung.component;

import com.yelinaung.luluaung.module.DataModule;
import com.yelinaung.luluaung.module.DataModule_ProvideDetailListFactory;
import com.yelinaung.luluaung.module.DataModule_ProvideGetUserListUseCaseFactory;
import com.yelinaung.luluaung.repo.CacheRepo;
import com.yelinaung.luluaung.repo.DataRepository;
import com.yelinaung.luluaung.threads.PostExecutionThread;
import com.yelinaung.luluaung.threads.ThreadExecutor;
import com.yelinaung.luluaung.useCases.GetItems;
import com.yelinaung.luluaung.useCases.GetItems_Factory;
import com.yelinaung.luluaung.useCases.ItemCases;
import com.yelinaung.luluaung.views.activities.DetailActivity;
import com.yelinaung.luluaung.views.activities.DetailActivity_MembersInjector;
import com.yelinaung.luluaung.views.activities.MainActivity;
import com.yelinaung.luluaung.views.activities.MainActivity_MembersInjector;
import com.yelinaung.luluaung.views.presenters.DetailPresenter;
import com.yelinaung.luluaung.views.presenters.DetailPresenter_Factory;
import com.yelinaung.luluaung.views.presenters.MainPresenter;
import com.yelinaung.luluaung.views.presenters.MainPresenter_Factory;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerDataComponent implements DataComponent {
  private Provider<ThreadExecutor> exeThreadProvider;

  private Provider<PostExecutionThread> uiThreadProvider;

  private Provider<DataRepository> dataRepoProvider;

  private Provider<GetItems> getItemsProvider;

  private Provider<ItemCases> provideGetUserListUseCaseProvider;

  private Provider<CacheRepo> cacheProvider;

  private Provider<MainPresenter> mainPresenterProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private Provider<CacheRepo> provideDetailListProvider;

  private Provider<DetailPresenter> detailPresenterProvider;

  private MembersInjector<DetailActivity> detailActivityMembersInjector;

  private DaggerDataComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.exeThreadProvider =
        new Factory<ThreadExecutor>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public ThreadExecutor get() {
            return Preconditions.checkNotNull(
                applicationComponent.exeThread(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.uiThreadProvider =
        new Factory<PostExecutionThread>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public PostExecutionThread get() {
            return Preconditions.checkNotNull(
                applicationComponent.uiThread(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.dataRepoProvider =
        new Factory<DataRepository>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public DataRepository get() {
            return Preconditions.checkNotNull(
                applicationComponent.dataRepo(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.getItemsProvider =
        GetItems_Factory.create(
            MembersInjectors.<GetItems>noOp(),
            exeThreadProvider,
            uiThreadProvider,
            dataRepoProvider);

    this.provideGetUserListUseCaseProvider =
        ScopedProvider.create(
            DataModule_ProvideGetUserListUseCaseFactory.create(
                builder.dataModule, getItemsProvider));

    this.cacheProvider =
        new Factory<CacheRepo>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public CacheRepo get() {
            return Preconditions.checkNotNull(
                applicationComponent.cache(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.mainPresenterProvider =
        ScopedProvider.create(
            MainPresenter_Factory.create(provideGetUserListUseCaseProvider, cacheProvider));

    this.mainActivityMembersInjector =
        MainActivity_MembersInjector.create(mainPresenterProvider, dataRepoProvider);

    this.provideDetailListProvider =
        ScopedProvider.create(
            DataModule_ProvideDetailListFactory.create(builder.dataModule, cacheProvider));

    this.detailPresenterProvider =
        ScopedProvider.create(DetailPresenter_Factory.create(provideDetailListProvider));

    this.detailActivityMembersInjector =
        DetailActivity_MembersInjector.create(detailPresenterProvider);
  }

  @Override
  public void inject(MainActivity arg0) {
    mainActivityMembersInjector.injectMembers(arg0);
  }

  @Override
  public void inject(DetailActivity arg0) {
    detailActivityMembersInjector.injectMembers(arg0);
  }

  public static final class Builder {
    private DataModule dataModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public DataComponent build() {
      if (dataModule == null) {
        this.dataModule = new DataModule();
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerDataComponent(this);
    }

    public Builder dataModule(DataModule dataModule) {
      this.dataModule = Preconditions.checkNotNull(dataModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
