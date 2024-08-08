
package com.sacral.repository;

import com.sacral.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE n.loanStatus = 'Approved'")
    List<Notification> findApprovedNotifications();

    @Query("SELECT n FROM Notification n WHERE n.customerId = ?1")
    List<Notification> findNotificationsByCustomerId(Long customerId);

    // Add more custom queries as needed

}
