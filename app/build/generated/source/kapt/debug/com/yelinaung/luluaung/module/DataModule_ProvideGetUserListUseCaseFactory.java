package com.yelinaung.luluaung.module;

import com.yelinaung.luluaung.useCases.GetItems;
import com.yelinaung.luluaung.useCases.ItemCases;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataModule_ProvideGetUserListUseCaseFactory implements Factory<ItemCases> {
  private final DataModule module;

  private final Provider<GetItems> arg0Provider;

  public DataModule_ProvideGetUserListUseCaseFactory(
      DataModule module, Provider<GetItems> arg0Provider) {
    assert module != null;
    this.module = module;
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
  }

  @Override
  public ItemCases get() {
    return Preconditions.checkNotNull(
        module.provideGetUserListUseCase(arg0Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ItemCases> create(DataModule module, Provider<GetItems> arg0Provider) {
    return new DataModule_ProvideGetUserListUseCaseFactory(module, arg0Provider);
  }
}
