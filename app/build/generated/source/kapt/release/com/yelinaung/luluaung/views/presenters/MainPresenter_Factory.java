package com.yelinaung.luluaung.views.presenters;

import com.yelinaung.luluaung.repo.CacheRepo;
import com.yelinaung.luluaung.useCases.ItemCases;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainPresenter_Factory implements Factory<MainPresenter> {
  private final Provider<ItemCases> arg0Provider;

  private final Provider<CacheRepo> arg1Provider;

  public MainPresenter_Factory(Provider<ItemCases> arg0Provider, Provider<CacheRepo> arg1Provider) {
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
    assert arg1Provider != null;
    this.arg1Provider = arg1Provider;
  }

  @Override
  public MainPresenter get() {
    return new MainPresenter(arg0Provider.get(), arg1Provider.get());
  }

  public static Factory<MainPresenter> create(
      Provider<ItemCases> arg0Provider, Provider<CacheRepo> arg1Provider) {
    return new MainPresenter_Factory(arg0Provider, arg1Provider);
  }
}
