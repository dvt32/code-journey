using System;
using System.Collections.Generic;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;

namespace Exercise6_Forms_Collections.Models
{
    public class ReservationDAO
    {
        private const String FILE_PATH = @"D:\output.bin";
        
        public void SaveReservationToFile(Reservation reservation)
        {
            using (var fileStream = new FileStream(FILE_PATH, FileMode.Append))
            {
                var bFormatter = new BinaryFormatter();
                bFormatter.Serialize(fileStream, reservation);
            }
        }

        public List<Reservation> GetReservationsFromFile()
        {
            List<Reservation> reservationList = new List<Reservation>();

            using (var fileStream = new FileStream(FILE_PATH, FileMode.Open))
            {
                var bFormatter = new BinaryFormatter();
                while (fileStream.Position != fileStream.Length)
                {
                    Reservation reservation = (Reservation) bFormatter.Deserialize(fileStream); 
                    reservationList.Add(reservation);
                }
            }

            return reservationList;
        }
    }
}