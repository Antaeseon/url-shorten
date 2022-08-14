package com.ts.urlshorten.application.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class UrlQueryDto {
	private String tinyUrl;
	private String originUrl;
	private String createdAt;

	@Builder
	public UrlQueryDto(String tinyUrl, String originUrl, String createdAt) {
		this.tinyUrl = tinyUrl;
		this.originUrl = originUrl;
		this.createdAt = createdAt;
	}
}
