package com.yelinaung.luluaung.module;

import com.yelinaung.luluaung.repo.CacheRepo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataModule_ProvideDetailListFactory implements Factory<CacheRepo> {
  private final DataModule module;

  private final Provider<CacheRepo> arg0Provider;

  public DataModule_ProvideDetailListFactory(DataModule module, Provider<CacheRepo> arg0Provider) {
    assert module != null;
    this.module = module;
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
  }

  @Override
  public CacheRepo get() {
    return Preconditions.checkNotNull(
        module.provideDetailList(arg0Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CacheRepo> create(DataModule module, Provider<CacheRepo> arg0Provider) {
    return new DataModule_ProvideDetailListFactory(module, arg0Provider);
  }
}
