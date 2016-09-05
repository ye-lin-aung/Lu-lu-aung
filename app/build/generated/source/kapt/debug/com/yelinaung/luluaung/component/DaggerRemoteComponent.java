package com.yelinaung.luluaung.component;

import com.yelinaung.luluaung.module.RemoteModule;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerRemoteComponent implements RemoteComponent {
  private DaggerRemoteComponent(Builder builder) {
    assert builder != null;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationComponent applicationComponent;

    private Builder() {}

    public RemoteComponent build() {
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerRemoteComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder remoteModule(RemoteModule remoteModule) {
      Preconditions.checkNotNull(remoteModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
