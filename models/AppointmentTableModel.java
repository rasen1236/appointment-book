import javax.swing.table.AbstractTableModel;

public class AppointmentTableModel extends AbstractTableModel {

    private Appointment[] appointments;
    private String[] columnNames = { "Customer Name", "Customer Phone", "Stylist Name", "Date"}; 

    public AppointmentTableModel(Appointment[] appointments) {
        this.appointments = appointments;
    }

    @Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return appointments.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
        Appointment appointment = appointments[rowIndex];
        switch (columnIndex) {
            case 0:
                value = appointment.getCustomerName();
                break;
            case 1:
                value = appointment.getCustomerPhone();
                break;
            case 2:
                value = appointment.getStylistName();
                break;
            case 3:
                value = appointment.getDate();
                break;
        }

        return value;

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class value = String.class;
        switch (columnIndex) {
            case 0:
                value = String.class;
                break;
            case 1:
                value = String.class;
                break;
            case 2:
                value = String.class;
                break;
            case 3:
                value = String.class;
                break;
        }

        return value;
    }

    /**
     * This will return the appointment at the specified row...
     * @param row
     * @return 
     */
    public Appointment getAppointmentAt(int row) {
        return appointments[i];
    }

}