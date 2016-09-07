package com.yelinaung.luluaung.UseCases;

import com.yelinaung.luluaung.repo.DataRepository;
import com.yelinaung.luluaung.threads.PostExecutionThread;
import com.yelinaung.luluaung.threads.ThreadExecutor;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetItems_Factory implements Factory<GetItems> {
  private final MembersInjector<GetItems> getItemsMembersInjector;

  private final Provider<ThreadExecutor> arg0Provider;

  private final Provider<PostExecutionThread> arg1Provider;

  private final Provider<DataRepository> arg2Provider;

  public GetItems_Factory(
      MembersInjector<GetItems> getItemsMembersInjector,
      Provider<ThreadExecutor> arg0Provider,
      Provider<PostExecutionThread> arg1Provider,
      Provider<DataRepository> arg2Provider) {
    assert getItemsMembersInjector != null;
    this.getItemsMembersInjector = getItemsMembersInjector;
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
    assert arg1Provider != null;
    this.arg1Provider = arg1Provider;
    assert arg2Provider != null;
    this.arg2Provider = arg2Provider;
  }

  @Override
  public GetItems get() {
    return MembersInjectors.injectMembers(
        getItemsMembersInjector,
        new GetItems(arg0Provider.get(), arg1Provider.get(), arg2Provider.get()));
  }

  public static Factory<GetItems> create(
      MembersInjector<GetItems> getItemsMembersInjector,
      Provider<ThreadExecutor> arg0Provider,
      Provider<PostExecutionThread> arg1Provider,
      Provider<DataRepository> arg2Provider) {
    return new GetItems_Factory(getItemsMembersInjector, arg0Provider, arg1Provider, arg2Provider);
  }
}
