package com.EmailAutomation.UserService.Service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheService {
    private final Map<String, String> otpCache = new ConcurrentHashMap<>();

    @CachePut(cacheNames = "otp", key = "#email")
    public void storeotp(String email, String otp) {
        otpCache.put(email, otp);
    }

    // Get OTP
    @Cacheable(cacheNames = "otp", key = "#email")
    public String getOtp(String email) {
        String OTP = otpCache.get(email);

        if (OTP == null) {
            throw new RuntimeException("Cache MISS for ->> null recieved: " + email);
        }
        return OTP;
    }

    // Remove OTP
    @CacheEvict(cacheNames = "otp", key = "#email")
    public void clearOtp(String email) {
        if(otpCache.containsKey(email)) {
            otpCache.remove(email);
        }
    }
}
