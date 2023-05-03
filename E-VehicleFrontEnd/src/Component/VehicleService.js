import axios from 'axios';

const VEHICLE_API_BASE_URL = "http://localhost:8080/Vehicle";

class VehicleService {

    getVehicles(){
        return axios.get(VEHICLE_API_BASE_URL);
    }

    createVehicle(vehicle){
        return axios.post(VEHICLE_API_BASE_URL, vehicle);
    }

    getVehicleById(id){
        return axios.get(VEHICLE_API_BASE_URL + '/' + id);
    }

    updateVehicle(vehicle, id){
        return axios.put(VEHICLE_API_BASE_URL + '/' + id, vehicle);
    }

    deleteVehicle(id){
        return axios.delete(VEHICLE_API_BASE_URL + '/' + id);
    }
}

export default new VehicleService()