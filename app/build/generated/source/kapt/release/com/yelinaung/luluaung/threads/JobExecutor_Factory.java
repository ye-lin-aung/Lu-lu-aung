package com.yelinaung.luluaung.threads;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum JobExecutor_Factory implements Factory<JobExecutor> {
  INSTANCE;

  @Override
  public JobExecutor get() {
    return new JobExecutor();
  }

  public static Factory<JobExecutor> create() {
    return INSTANCE;
  }
}
