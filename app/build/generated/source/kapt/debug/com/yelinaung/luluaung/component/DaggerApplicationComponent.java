package com.yelinaung.luluaung.component;

import android.content.Context;
import com.yelinaung.luluaung.module.ApplicationModule;
import com.yelinaung.luluaung.module.ApplicationModule_ContextFactory;
import com.yelinaung.luluaung.module.ApplicationModule_MainThreadFactory;
import com.yelinaung.luluaung.module.ApplicationModule_RetrofitFactory;
import com.yelinaung.luluaung.module.ApplicationModule_ThreadExecutorFactory;
import com.yelinaung.luluaung.threads.JobExecutor;
import com.yelinaung.luluaung.threads.JobExecutor_Factory;
import com.yelinaung.luluaung.threads.PostExecutionThread;
import com.yelinaung.luluaung.threads.ThreadExecutor;
import com.yelinaung.luluaung.threads.UIThread;
import com.yelinaung.luluaung.threads.UIThread_Factory;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> contextProvider;

  private Provider<Retrofit> retrofitProvider;

  private Provider<JobExecutor> jobExecutorProvider;

  private Provider<ThreadExecutor> threadExecutorProvider;

  private Provider<UIThread> uIThreadProvider;

  private Provider<PostExecutionThread> mainThreadProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.contextProvider =
        ScopedProvider.create(ApplicationModule_ContextFactory.create(builder.applicationModule));

    this.retrofitProvider =
        ScopedProvider.create(ApplicationModule_RetrofitFactory.create(builder.applicationModule));

    this.jobExecutorProvider = ScopedProvider.create(JobExecutor_Factory.create());

    this.threadExecutorProvider =
        ScopedProvider.create(
            ApplicationModule_ThreadExecutorFactory.create(
                builder.applicationModule, jobExecutorProvider));

    this.uIThreadProvider = ScopedProvider.create(UIThread_Factory.create());

    this.mainThreadProvider =
        ScopedProvider.create(
            ApplicationModule_MainThreadFactory.create(
                builder.applicationModule, uIThreadProvider));
  }

  @Override
  public Context context() {
    return contextProvider.get();
  }

  @Override
  public Retrofit retrofit() {
    return retrofitProvider.get();
  }

  @Override
  public ThreadExecutor exeThread() {
    return threadExecutorProvider.get();
  }

  @Override
  public PostExecutionThread uiThread() {
    return mainThreadProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }
}
