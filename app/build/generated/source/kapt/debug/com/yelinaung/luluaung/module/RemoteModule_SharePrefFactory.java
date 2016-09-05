package com.yelinaung.luluaung.module;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RemoteModule_SharePrefFactory implements Factory<SharedPreferences> {
  private final RemoteModule module;

  private final Provider<Context> arg0Provider;

  public RemoteModule_SharePrefFactory(RemoteModule module, Provider<Context> arg0Provider) {
    assert module != null;
    this.module = module;
    assert arg0Provider != null;
    this.arg0Provider = arg0Provider;
  }

  @Override
  public SharedPreferences get() {
    return Preconditions.checkNotNull(
        module.sharePref(arg0Provider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SharedPreferences> create(
      RemoteModule module, Provider<Context> arg0Provider) {
    return new RemoteModule_SharePrefFactory(module, arg0Provider);
  }
}
