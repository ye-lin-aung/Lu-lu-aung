package com.yelinaung.luluaung.component;

import android.content.Context;
import com.yelinaung.luluaung.UseCases.GetItems;
import com.yelinaung.luluaung.UseCases.GetItems_Factory;
import com.yelinaung.luluaung.UseCases.ItemCases;
import com.yelinaung.luluaung.module.DataModule;
import com.yelinaung.luluaung.module.DataModule_ProvideGetUserListUseCaseFactory;
import com.yelinaung.luluaung.repo.DataRepository;
import com.yelinaung.luluaung.repo.DataRepository_Factory;
import com.yelinaung.luluaung.repo.DataRepository_MembersInjector;
import com.yelinaung.luluaung.repo.RemoteDataRepository;
import com.yelinaung.luluaung.repo.RemoteDataRepository_Factory;
import com.yelinaung.luluaung.threads.PostExecutionThread;
import com.yelinaung.luluaung.threads.ThreadExecutor;
import com.yelinaung.luluaung.views.activities.MainActivity;
import com.yelinaung.luluaung.views.activities.MainActivity_MembersInjector;
import com.yelinaung.luluaung.views.presenters.MainPresenter;
import com.yelinaung.luluaung.views.presenters.MainPresenter_Factory;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerDataComponent implements DataComponent {
  private Provider<ThreadExecutor> exeThreadProvider;

  private Provider<PostExecutionThread> uiThreadProvider;

  private Provider<Retrofit> retrofitProvider;

  private Provider<Context> contextProvider;

  private Provider<RemoteDataRepository> remoteDataRepositoryProvider;

  private MembersInjector<DataRepository> dataRepositoryMembersInjector;

  private Provider<DataRepository> dataRepositoryProvider;

  private Provider<GetItems> getItemsProvider;

  private Provider<ItemCases> provideGetUserListUseCaseProvider;

  private Provider<MainPresenter> mainPresenterProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

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

    this.retrofitProvider =
        new Factory<Retrofit>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public Retrofit get() {
            return Preconditions.checkNotNull(
                applicationComponent.retrofit(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.contextProvider =
        new Factory<Context>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public Context get() {
            return Preconditions.checkNotNull(
                applicationComponent.context(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.remoteDataRepositoryProvider =
        RemoteDataRepository_Factory.create(retrofitProvider, contextProvider);

    this.dataRepositoryMembersInjector =
        DataRepository_MembersInjector.create(remoteDataRepositoryProvider);

    this.dataRepositoryProvider = DataRepository_Factory.create(dataRepositoryMembersInjector);

    this.getItemsProvider =
        GetItems_Factory.create(
            MembersInjectors.<GetItems>noOp(),
            exeThreadProvider,
            uiThreadProvider,
            dataRepositoryProvider);

    this.provideGetUserListUseCaseProvider =
        ScopedProvider.create(
            DataModule_ProvideGetUserListUseCaseFactory.create(
                builder.dataModule, getItemsProvider));

    this.mainPresenterProvider =
        ScopedProvider.create(MainPresenter_Factory.create(provideGetUserListUseCaseProvider));

    this.mainActivityMembersInjector =
        MainActivity_MembersInjector.create(mainPresenterProvider, dataRepositoryProvider);
  }

  @Override
  public void inject(MainActivity arg0) {
    mainActivityMembersInjector.injectMembers(arg0);
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
