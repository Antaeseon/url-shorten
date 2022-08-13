package com.ts.urlshorten.application.util;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Base62Test {

	@Test
	@DisplayName("encoding decoding 작동 확인")
	public void encoding_test() throws Exception {
		//given
		long input = 12345568L;
		//when
		Assertions.assertThat(input).isEqualTo(Base62.decoding(Base62.encoding(input)));
	}
}