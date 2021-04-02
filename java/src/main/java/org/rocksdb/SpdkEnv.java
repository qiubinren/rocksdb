package org.rocksdb;

public class SpdkEnv extends Env {

  /**
   <p>Creates a new environment that is used for spdk environment.</p>
   *
   * <p>The caller must delete the result when it is
   * no longer needed.</p>
   *
   * @param baseEnv the base env
   * @param dbName need open dbName
   * @param confName such as "/usr/local/etc/spdk/rocksdb.conf"
   * @param bdevName such as "aio0"
   * @param spdkCacheSize the spdk env use cache size
   */
  public SpdkEnv(final Env baseEnv, final String dbName, final String confName,
      final String bdevName, final int spdkCacheSize) {
    super(createSpdkEnv(baseEnv.nativeHandle_, dbName, confName, bdevName, spdkCacheSize));
  }

  private static native long createSpdkEnv(final long baseEnvHandle,
      final String dbName, final String confName, final String bdevName, final int spdkCacheSize);

  @Override protected final native void disposeInternal(final long handle);
}
