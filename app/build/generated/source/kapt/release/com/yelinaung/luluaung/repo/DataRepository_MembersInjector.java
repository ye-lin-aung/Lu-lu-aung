package com.yelinaung.luluaung.repo;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataRepository_MembersInjector implements MembersInjector<DataRepository> {
  private final Provider<RemoteDataRepository> dataRepositoryProvider;

  public DataRepository_MembersInjector(Provider<RemoteDataRepository> dataRepositoryProvider) {
    assert dataRepositoryProvider != null;
    this.dataRepositoryProvider = dataRepositoryProvider;
  }

  public static MembersInjector<DataRepository> create(
      Provider<RemoteDataRepository> dataRepositoryProvider) {
    return new DataRepository_MembersInjector(dataRepositoryProvider);
  }

  @Override
  public void injectMembers(DataRepository instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.dataRepository = dataRepositoryProvider.get();
  }
}
