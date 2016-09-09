package com.yelinaung.luluaung.views.presenters;

import com.yelinaung.luluaung.repo.CacheRepo;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DetailPresenter_Factory implements Factory<DetailPresenter> {
  private final Provider<CacheRepo> arg0Provider;

  public DetailPresenter_Factory(Provider<CacheRepo> arg0Provider) {
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
  }

  @Override
  public DetailPresenter get() {
    return new DetailPresenter(arg0Provider.get());
  }

  public static Factory<DetailPresenter> create(Provider<CacheRepo> arg0Provider) {
    return new DetailPresenter_Factory(arg0Provider);
  }
}
