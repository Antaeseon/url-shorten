package com.ts.urlshorten.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ts.urlshorten.application.dto.GenerateDto;
import com.ts.urlshorten.application.util.Base62;
import com.ts.urlshorten.domain.common.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UrlMappingInfo extends BaseTimeEntity {
	@Id @GeneratedValue
	private Long id;

	@Column(unique = true)
	private String originUrl;

	private String tinyUrl;


	public static UrlMappingInfo createUrlMappingInfo(GenerateDto.Request request){

		return UrlMappingInfo.builder()
			.originUrl(request.getUrl())
			.build();
	}

	public void generateTinyUrl() {
		this.tinyUrl = Base62.encoding(this.id);
	}


	@Builder
	private UrlMappingInfo(String originUrl, String tinyUrl) {
		this.originUrl = originUrl;
		this.tinyUrl = tinyUrl;
	}
}
