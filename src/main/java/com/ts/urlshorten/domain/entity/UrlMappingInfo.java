package com.ts.urlshorten.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ts.urlshorten.domain.common.BaseTimeEntity;

import lombok.AccessLevel;
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

}
