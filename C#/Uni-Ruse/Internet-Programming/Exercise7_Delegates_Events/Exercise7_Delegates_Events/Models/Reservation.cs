using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Exercise7_Delegates_Events.Models
{
    [Serializable]
    public class Reservation
    {
        private String roomType;
        private String startDate;
        private String endDate;
        private String fullName;
        private String paymentMethod;
        private String message;

        // Auto-generated getters & setters
        public string RoomType
        {
            get
            {
                return roomType;
            }

            set
            {
                roomType = value;
            }
        }

        public string StartDate
        {
            get
            {
                return startDate;
            }

            set
            {
                startDate = value;
            }
        }

        public string EndDate
        {
            get
            {
                return endDate;
            }

            set
            {
                endDate = value;
            }
        }

        public string FullName
        {
            get
            {
                return fullName;
            }

            set
            {
                fullName = value;
            }
        }

        public string PaymentMethod
        {
            get
            {
                return paymentMethod;
            }

            set
            {
                paymentMethod = value;
            }
        }

        public string Message
        {
            get
            {
                return message;
            }

            set
            {
                message = value;
            }
        }
    }
}