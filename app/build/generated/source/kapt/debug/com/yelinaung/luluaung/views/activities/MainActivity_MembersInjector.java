package com.yelinaung.luluaung.views.activities;

import com.yelinaung.luluaung.repo.DataRepository;
import com.yelinaung.luluaung.views.presenters.MainPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<MainPresenter> userListPresenterProvider;

  private final Provider<DataRepository> dataRepoProvider;

  public MainActivity_MembersInjector(
      Provider<MainPresenter> userListPresenterProvider,
      Provider<DataRepository> dataRepoProvider) {
    assert userListPresenterProvider != null;
    this.userListPresenterProvider = userListPresenterProvider;
    assert dataRepoProvider != null;
    this.dataRepoProvider = dataRepoProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<MainPresenter> userListPresenterProvider,
      Provider<DataRepository> dataRepoProvider) {
    return new MainActivity_MembersInjector(userListPresenterProvider, dataRepoProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.userListPresenter = userListPresenterProvider.get();
    instance.dataRepo = dataRepoProvider.get();
  }
}
