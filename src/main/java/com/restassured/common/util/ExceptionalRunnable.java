package com.restassured.common.util;

import java.sql.ResultSet;

@FunctionalInterface
public interface ExceptionalRunnable {
	void run(final ResultSet rs, Object o) throws Exception;
}
