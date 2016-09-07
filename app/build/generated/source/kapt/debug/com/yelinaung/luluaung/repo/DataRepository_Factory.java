package com.yelinaung.luluaung.repo;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataRepository_Factory implements Factory<DataRepository> {
  private final MembersInjector<DataRepository> dataRepositoryMembersInjector;

  public DataRepository_Factory(MembersInjector<DataRepository> dataRepositoryMembersInjector) {
    assert dataRepositoryMembersInjector != null;
    this.dataRepositoryMembersInjector = dataRepositoryMembersInjector;
  }

  @Override
  public DataRepository get() {
    return MembersInjectors.injectMembers(dataRepositoryMembersInjector, new DataRepository());
  }

  public static Factory<DataRepository> create(
      MembersInjector<DataRepository> dataRepositoryMembersInjector) {
    return new DataRepository_Factory(dataRepositoryMembersInjector);
  }
}
