package com.yelinaung.luluaung.repo;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoteDataRepository_Factory implements Factory<RemoteDataRepository> {
  private final Provider<Retrofit> arg0Provider;

  private final Provider<Context> arg1Provider;

  private final Provider<SharedPreferences> arg2Provider;

  public RemoteDataRepository_Factory(
      Provider<Retrofit> arg0Provider,
      Provider<Context> arg1Provider,
      Provider<SharedPreferences> arg2Provider) {
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
    assert arg1Provider != null;
    this.arg1Provider = arg1Provider;
    assert arg2Provider != null;
    this.arg2Provider = arg2Provider;
  }

  @Override
  public RemoteDataRepository get() {
    return new RemoteDataRepository(arg0Provider.get(), arg1Provider.get(), arg2Provider.get());
  }

  public static Factory<RemoteDataRepository> create(
      Provider<Retrofit> arg0Provider,
      Provider<Context> arg1Provider,
      Provider<SharedPreferences> arg2Provider) {
    return new RemoteDataRepository_Factory(arg0Provider, arg1Provider, arg2Provider);
  }
}