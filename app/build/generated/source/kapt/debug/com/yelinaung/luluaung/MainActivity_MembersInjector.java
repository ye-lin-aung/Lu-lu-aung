package com.yelinaung.luluaung;

import android.support.v7.app.AppCompatActivity;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final MembersInjector<AppCompatActivity> supertypeInjector;
  private final Provider<Retrofit> retrofitProvider;

  public MainActivity_MembersInjector(MembersInjector<AppCompatActivity> supertypeInjector, Provider<Retrofit> retrofitProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public void injectMembers(MainActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.retrofit = retrofitProvider.get();
  }

  public static MembersInjector<MainActivity> create(MembersInjector<AppCompatActivity> supertypeInjector, Provider<Retrofit> retrofitProvider) {  
      return new MainActivity_MembersInjector(supertypeInjector, retrofitProvider);
  }
}

