/*
 * Copyright (c) 2010, Paul Merlin. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.qi4j.library.scheduler;

import static org.qi4j.api.unitofwork.UnitOfWorkPropagation.Propagation.MANDATORY;

import java.util.Date;

import org.qi4j.api.concern.Concerns;
import org.qi4j.api.unitofwork.UnitOfWorkConcern;
import org.qi4j.api.unitofwork.UnitOfWorkPropagation;

import org.qi4j.library.scheduler.constraints.CronExpression;
import org.qi4j.library.scheduler.schedule.Schedule;
import org.qi4j.library.scheduler.task.Task;

/**
 * To make a Schedule durable, set it's durable property to true once its scheduled.
 * Durable Schedules that have no future run are removed by SchedulerGarbageCollector.
 */
@Concerns( UnitOfWorkConcern.class )
public interface Scheduler
{

    @UnitOfWorkPropagation( MANDATORY )
    Schedule scheduleOnce( Task task, long initialDelay );

    @UnitOfWorkPropagation( MANDATORY )
    Schedule shedule( Task task, @CronExpression String cronExpression );

    @UnitOfWorkPropagation( MANDATORY )
    Schedule shedule( Task task, @CronExpression String cronExpression, long initialDelay );

    @UnitOfWorkPropagation( MANDATORY )
    Schedule shedule( Task task, @CronExpression String cronExpression, Date start );

}