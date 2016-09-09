package com.yelinaung.luluaung.module;

import com.yelinaung.luluaung.threads.PostExecutionThread;
import com.yelinaung.luluaung.threads.UIThread;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_MainThreadFactory implements Factory<PostExecutionThread> {
  private final ApplicationModule module;

  private final Provider<UIThread> arg0Provider;

  public ApplicationModule_MainThreadFactory(
      ApplicationModule module, Provider<UIThread> arg0Provider) {
    assert module != null;
    this.module = module;
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
  }

  @Override
  public PostExecutionThread get() {
    return Preconditions.checkNotNull(
        module.mainThread(arg0Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PostExecutionThread> create(
      ApplicationModule module, Provider<UIThread> arg0Provider) {
    return new ApplicationModule_MainThreadFactory(module, arg0Provider);
  }
}
