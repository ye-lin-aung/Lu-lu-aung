package com.yelinaung.luluaung.module;

import dagger.internal.Factory;
import javax.annotation.Generated;
import retrofit2.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class RetrofitModule_RetrofitFactory implements Factory<Retrofit> {
  private final RetrofitModule module;

  public RetrofitModule_RetrofitFactory(RetrofitModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Retrofit get() {  
    Retrofit provided = module.retrofit();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Retrofit> create(RetrofitModule module) {  
    return new RetrofitModule_RetrofitFactory(module);
  }
}

