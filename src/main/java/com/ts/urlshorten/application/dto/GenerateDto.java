package com.ts.urlshorten.application.dto;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class GenerateDto {
	@Getter
	@Setter
	@ToString
	@EqualsAndHashCode
	@NoArgsConstructor
	public static class Request{
		@NotNull
		private String url;

	}

	@Getter
	@Setter
	@ToString
	@EqualsAndHashCode
	@NoArgsConstructor
	public static class Response{
		private String tinyUrl;
		private String originUrl;
		private String createdAt;

		@Builder
		public Response(String tinyUrl, String originUrl, String createdAt) {
			this.tinyUrl = tinyUrl;
			this.originUrl = originUrl;
			this.createdAt = createdAt;
		}
	}
}
