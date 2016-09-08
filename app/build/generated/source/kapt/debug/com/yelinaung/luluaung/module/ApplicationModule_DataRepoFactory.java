package com.yelinaung.luluaung.module;

import com.yelinaung.luluaung.repo.DataRepository;
import com.yelinaung.luluaung.repo.Repository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_DataRepoFactory implements Factory<Repository> {
  private final ApplicationModule module;

  private final Provider<DataRepository> arg0Provider;

  public ApplicationModule_DataRepoFactory(
      ApplicationModule module, Provider<DataRepository> arg0Provider) {
    assert module != null;
    this.module = module;
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
  }

  @Override
  public Repository get() {
    return Preconditions.checkNotNull(
        module.dataRepo(arg0Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Repository> create(
      ApplicationModule module, Provider<DataRepository> arg0Provider) {
    return new ApplicationModule_DataRepoFactory(module, arg0Provider);
  }
}
