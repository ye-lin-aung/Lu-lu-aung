package com.yelinaung.luluaung.views.presenters;

import com.yelinaung.luluaung.UseCases.ItemCases;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainPresenter_Factory implements Factory<MainPresenter> {
  private final Provider<ItemCases> arg0Provider;

  public MainPresenter_Factory(Provider<ItemCases> arg0Provider) {
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
  }

  @Override
  public MainPresenter get() {
    return new MainPresenter(arg0Provider.get());
  }

  public static Factory<MainPresenter> create(Provider<ItemCases> arg0Provider) {
    return new MainPresenter_Factory(arg0Provider);
  }
}
