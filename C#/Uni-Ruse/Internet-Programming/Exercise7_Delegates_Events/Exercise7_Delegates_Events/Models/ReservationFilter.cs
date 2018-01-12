using System;
using System.Collections.Generic;

namespace Exercise7_Delegates_Events.Models
{
    public class ReservationFilter
    {
        public delegate bool FilterDelegate(Reservation res);

        protected static bool HasHotelMessage(Reservation res)
        {
            return (res.Message != null && res.Message.Length != 0);
        }

        protected static bool IsOnePersonReservation(Reservation res)
        {
            return (res.RoomType.Equals("1 person"));
        }

        protected static bool IsTwoPeopleReservation(Reservation res)
        {
            return (res.RoomType.Equals("2 people"));
        }

        protected static bool IsThreePeopleReservation(Reservation res)
        {
            return (res.RoomType.Equals("3 people"));
        }

        // Filter reservations method #1 - via custom delegate
        /*
        public static List<Reservation> Filter(FilterDelegate filter, List<Reservation> reservations)
        {
            List<Reservation> filteredReservations = new List<Reservation>();

            foreach (Reservation res in reservations)
            {
                bool passesFilter = filter(res);
                if (passesFilter)
                {
                    filteredReservations.Add(res);
                }
            }

            return filteredReservations;
        }
        */

        // Filter reservations method #2 - via built-in Func delegate
        Func<Reservation, bool> FuncFilterDelegate;
        public static List<Reservation> Filter(Func<Reservation, bool> filter, List<Reservation> reservations)
        {
            List<Reservation> filteredReservations = new List<Reservation>();

            foreach (Reservation res in reservations)
            {
                bool passesFilter = filter(res);
                if (passesFilter)
                {
                    filteredReservations.Add(res);
                }
            }

            return filteredReservations;
        }

    }
}