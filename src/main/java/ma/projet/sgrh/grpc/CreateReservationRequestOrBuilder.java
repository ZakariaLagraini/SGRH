// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: reservation.proto

package ma.projet.sgrh.grpc;

public interface CreateReservationRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:CreateReservationRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string client_id = 1;</code>
   * @return The clientId.
   */
  java.lang.String getClientId();
  /**
   * <code>string client_id = 1;</code>
   * @return The bytes for clientId.
   */
  com.google.protobuf.ByteString
      getClientIdBytes();

  /**
   * <code>string chambre_id = 2;</code>
   * @return The chambreId.
   */
  java.lang.String getChambreId();
  /**
   * <code>string chambre_id = 2;</code>
   * @return The bytes for chambreId.
   */
  com.google.protobuf.ByteString
      getChambreIdBytes();

  /**
   * <code>string date_debut = 3;</code>
   * @return The dateDebut.
   */
  java.lang.String getDateDebut();
  /**
   * <code>string date_debut = 3;</code>
   * @return The bytes for dateDebut.
   */
  com.google.protobuf.ByteString
      getDateDebutBytes();

  /**
   * <code>string date_fin = 4;</code>
   * @return The dateFin.
   */
  java.lang.String getDateFin();
  /**
   * <code>string date_fin = 4;</code>
   * @return The bytes for dateFin.
   */
  com.google.protobuf.ByteString
      getDateFinBytes();

  /**
   * <code>string preferences = 5;</code>
   * @return The preferences.
   */
  java.lang.String getPreferences();
  /**
   * <code>string preferences = 5;</code>
   * @return The bytes for preferences.
   */
  com.google.protobuf.ByteString
      getPreferencesBytes();
}
