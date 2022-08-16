package com.ts.urlshorten.application.service;

import java.util.Objects;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ts.urlshorten.application.dto.GenerateDto;
import com.ts.urlshorten.application.dto.UrlQueryDto;
import com.ts.urlshorten.domain.entity.UrlMappingInfo;
import com.ts.urlshorten.infrastructure.repository.UrlMappingInfoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UrlShortenerServiceImpl implements UrlShortenerService{
	private final RedisTemplate<String, Object> redisTemplate;
	private final UrlMappingInfoRepository urlMappingInfoRepository;

	@Override
	@Transactional
	public GenerateDto.Response generateShortUrl(GenerateDto.Request request) throws Exception {
		UrlMappingInfo urlMappingInfo = UrlMappingInfo.createUrlMappingInfo(request);

		urlMappingInfoRepository.save(urlMappingInfo);

		urlMappingInfo.generateTinyUrl();

		return GenerateDto.Response.builder()
			.originUrl(urlMappingInfo.getOriginUrl())
			.tinyUrl(urlMappingInfo.getTinyUrl())
			.createdAt(urlMappingInfo.getCreatedAt().toString())
			.build();
	}

	@Override
	public UrlQueryDto findUrl(String tinyUrl) throws Exception {

		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		UrlQueryDto response = (UrlQueryDto)valueOperations.get(tinyUrl);
		if(response==null){
			UrlMappingInfo urlInfo = urlMappingInfoRepository.findByTinyUrl(tinyUrl)
				.orElseThrow(() -> new IllegalArgumentException("잘못된 Url"));
			UrlQueryDto responseDto = UrlQueryDto.builder()
				.tinyUrl(urlInfo.getTinyUrl())
				.originUrl(urlInfo.getOriginUrl())
				.createdAt(urlInfo.getCreatedAt().toString())
				.build();
			valueOperations.set(tinyUrl, responseDto);

			return responseDto;
		}else{
			return response;
		}



	}

	@Override
	public String redirectUrl(String tinyUrl) throws Exception {
		return null;
	}
}
