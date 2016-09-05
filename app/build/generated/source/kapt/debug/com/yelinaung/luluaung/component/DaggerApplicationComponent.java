package com.yelinaung.luluaung.component;

import android.content.Context;
import com.yelinaung.luluaung.module.ApplicationModule;
import com.yelinaung.luluaung.module.ApplicationModule_ContextFactory;
import com.yelinaung.luluaung.module.ApplicationModule_RetrofitFactory;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> contextProvider;

  private Provider<Retrofit> retrofitProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.contextProvider =
        ScopedProvider.create(ApplicationModule_ContextFactory.create(builder.applicationModule));

    this.retrofitProvider =
        ScopedProvider.create(ApplicationModule_RetrofitFactory.create(builder.applicationModule));
  }

  @Override
  public Context context() {
    return contextProvider.get();
  }

  @Override
  public Retrofit retrofit() {
    return retrofitProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }
}
