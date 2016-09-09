package com.yelinaung.luluaung.module;

import com.yelinaung.luluaung.threads.JobExecutor;
import com.yelinaung.luluaung.threads.ThreadExecutor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ThreadExecutorFactory implements Factory<ThreadExecutor> {
  private final ApplicationModule module;

  private final Provider<JobExecutor> arg0Provider;

  public ApplicationModule_ThreadExecutorFactory(
      ApplicationModule module, Provider<JobExecutor> arg0Provider) {
    assert module != null;
    this.module = module;
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
  }

  @Override
  public ThreadExecutor get() {
    return Preconditions.checkNotNull(
        module.threadExecutor(arg0Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ThreadExecutor> create(
      ApplicationModule module, Provider<JobExecutor> arg0Provider) {
    return new ApplicationModule_ThreadExecutorFactory(module, arg0Provider);
  }
}
