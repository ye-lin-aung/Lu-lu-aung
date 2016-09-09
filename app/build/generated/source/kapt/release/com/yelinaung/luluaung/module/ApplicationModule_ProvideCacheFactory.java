package com.yelinaung.luluaung.module;

import com.yelinaung.luluaung.repo.CacheRepo;
import com.yelinaung.luluaung.repo.Repo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideCacheFactory implements Factory<Repo> {
  private final ApplicationModule module;

  private final Provider<CacheRepo> arg0Provider;

  public ApplicationModule_ProvideCacheFactory(
      ApplicationModule module, Provider<CacheRepo> arg0Provider) {
    assert module != null;
    this.module = module;
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
  }

  @Override
  public Repo get() {
    return Preconditions.checkNotNull(
        module.provideCache(arg0Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Repo> create(ApplicationModule module, Provider<CacheRepo> arg0Provider) {
    return new ApplicationModule_ProvideCacheFactory(module, arg0Provider);
  }
}
