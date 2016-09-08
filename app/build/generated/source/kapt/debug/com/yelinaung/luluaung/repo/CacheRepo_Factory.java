package com.yelinaung.luluaung.repo;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum CacheRepo_Factory implements Factory<CacheRepo> {
  INSTANCE;

  @Override
  public CacheRepo get() {
    return new CacheRepo();
  }

  public static Factory<CacheRepo> create() {
    return INSTANCE;
  }
}
