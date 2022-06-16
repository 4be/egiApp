package com.egiapp.demo.services;

import com.egiapp.demo.model.request.StatusRequest;

public interface StatusService {

    Object getStatuses();

    Object getStatus(Long userId);

    Object getStatusUser(Long no);

    Object getSumUser(Long no);

    Object createStatus(StatusRequest statusRequest);

    Object updateStatus(Long userId, StatusRequest statusRequest);

    Object deleteStatus(Long userId);

    Object deleteStatuses();

}
