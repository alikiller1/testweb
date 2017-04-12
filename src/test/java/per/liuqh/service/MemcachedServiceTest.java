package per.liuqh.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import per.liuqh.common.TestBaseCase;
import per.liuqh.memcached.MemcachedUtils;

public class MemcachedServiceTest extends TestBaseCase {
	@Autowired
	private MemcachedUtils service;

	@Test
	public void test1() {
		Assert.assertNotNull(service);
	}

}
