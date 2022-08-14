package com.ts.urlshorten.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ts.urlshorten.domain.entity.UrlMappingInfo;

public interface UrlMappingInfoRepository extends JpaRepository<UrlMappingInfo,Long> {
	Optional<UrlMappingInfo> findByTinyUrl(String tinyUrl);
}
