package com.yelinaung.luluaung.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_RetrofitFactory implements Factory<Retrofit> {
  private final ApplicationModule module;

  public ApplicationModule_RetrofitFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.retrofit(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit> create(ApplicationModule module) {
    return new ApplicationModule_RetrofitFactory(module);
  }
}
