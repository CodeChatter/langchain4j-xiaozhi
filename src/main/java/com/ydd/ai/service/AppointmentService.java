package com.ydd.ai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ydd.ai.entity.Appointment;

/**
 * description
 *
 * @author yangjx
 * @date 2025年07月21日 17:16
 */
public interface AppointmentService extends IService<Appointment> {


    Appointment getOne(Appointment appointment);

}

