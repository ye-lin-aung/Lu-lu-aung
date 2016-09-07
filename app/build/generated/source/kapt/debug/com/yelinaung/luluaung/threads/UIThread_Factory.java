package com.yelinaung.luluaung.threads;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum UIThread_Factory implements Factory<UIThread> {
  INSTANCE;

  @Override
  public UIThread get() {
    return new UIThread();
  }

  public static Factory<UIThread> create() {
    return INSTANCE;
  }
}
