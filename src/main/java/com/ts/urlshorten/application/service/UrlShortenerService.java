package com.ts.urlshorten.application.service;

import com.ts.urlshorten.application.dto.GenerateDto;
import com.ts.urlshorten.application.dto.UrlQueryDto;

public interface UrlShortenerService {
	GenerateDto.Response generateShortUrl(GenerateDto.Request request) throws Exception;

	UrlQueryDto findUrl(String shortUrl) throws Exception;

	String redirectUrl(String shortUrl) throws Exception;

}
