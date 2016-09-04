package com.yelinaung.luluaung.component;

import com.yelinaung.luluaung.MainActivity;
import com.yelinaung.luluaung.MainActivity_MembersInjector;
import com.yelinaung.luluaung.module.RetrofitModule;
import com.yelinaung.luluaung.module.RetrofitModule_RetrofitFactory;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Retrofit> retrofitProvider;
  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private DaggerApplicationComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  public static ApplicationComponent create() {  
    return builder().build();
  }

  private void initialize(final Builder builder) {  
    this.retrofitProvider = RetrofitModule_RetrofitFactory.create(builder.retrofitModule);
    this.mainActivityMembersInjector = MainActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), retrofitProvider);
  }

  @Override
  public void inject(MainActivity arg0) {  
    mainActivityMembersInjector.injectMembers(arg0);
  }

  public static final class Builder {
    private RetrofitModule retrofitModule;
  
    private Builder() {  
    }
  
    public ApplicationComponent build() {  
      if (retrofitModule == null) {
        this.retrofitModule = new RetrofitModule();
      }
      return new DaggerApplicationComponent(this);
    }
  
    public Builder retrofitModule(RetrofitModule retrofitModule) {  
      if (retrofitModule == null) {
        throw new NullPointerException("retrofitModule");
      }
      this.retrofitModule = retrofitModule;
      return this;
    }
  }
}

