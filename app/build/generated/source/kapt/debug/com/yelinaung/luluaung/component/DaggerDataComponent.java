package com.yelinaung.luluaung.component;

import com.yelinaung.luluaung.MainActivity;
import com.yelinaung.luluaung.module.DataModule;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerDataComponent implements DataComponent {
  private DaggerDataComponent(Builder builder) {
    assert builder != null;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public void inject(MainActivity arg0) {
    MembersInjectors.<MainActivity>noOp().injectMembers(arg0);
  }

  public static final class Builder {
    private ApplicationComponent applicationComponent;

    private Builder() {}

    public DataComponent build() {
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerDataComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder dataModule(DataModule dataModule) {
      Preconditions.checkNotNull(dataModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
