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
public final class RemoteModule_GetRemoteDataSourceFactory implements Factory<Repository> {
  private final RemoteModule module;

  private final Provider<RemoteDataRepository> arg0Provider;

  public RemoteModule_GetRemoteDataSourceFactory(
      RemoteModule module, Provider<RemoteDataRepository> arg0Provider) {
    assert module != null;
    this.module = module;
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
  }

  @Override
  public Repository get() {
    return Preconditions.checkNotNull(
        module.getRemoteDataSource(arg0Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Repository> create(
      RemoteModule module, Provider<RemoteDataRepository> arg0Provider) {
    return new RemoteModule_GetRemoteDataSourceFactory(module, arg0Provider);
  }
}
