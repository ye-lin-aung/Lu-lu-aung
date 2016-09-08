package com.yelinaung.luluaung.module;

import com.yelinaung.luluaung.repo.RemoteDataRepository;
import com.yelinaung.luluaung.repo.Repository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_RemoteFactory implements Factory<Repository> {
  private final ApplicationModule module;

  private final Provider<RemoteDataRepository> arg0Provider;

  public ApplicationModule_RemoteFactory(
      ApplicationModule module, Provider<RemoteDataRepository> arg0Provider) {
    assert module != null;
    this.module = module;
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
  }

  @Override
  public Repository get() {
    return Preconditions.checkNotNull(
        module.remote(arg0Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Repository> create(
      ApplicationModule module, Provider<RemoteDataRepository> arg0Provider) {
    return new ApplicationModule_RemoteFactory(module, arg0Provider);
  }
}
