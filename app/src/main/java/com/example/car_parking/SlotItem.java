package com.example.car_parking;

public class SlotItem {
    public boolean slot1;
    public boolean slot2;
    public boolean slot3;
    public boolean slot4;
    public boolean slot5;
    public boolean slot6;
    public boolean slot7;
    public boolean slot8;
    public boolean slot9;
    public boolean slot10;

    public SlotItem(){}

    public SlotItem(boolean slot1, boolean slot2, boolean slot3, boolean slot4, boolean slot5,
                    boolean slot6, boolean slot7, boolean slot8, boolean slot9, boolean slot10) {
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.slot3 = slot3;
        this.slot4 = slot4;
        this.slot5 = slot5;
        this.slot6 = slot6;
        this.slot7 = slot7;
        this.slot8 = slot8;
        this.slot9 = slot9;
        this.slot10 = slot10;
    }

    public boolean isSlot1() {
        return slot1;
    }

    public void setSlot1(boolean slot1) {
        this.slot1 = slot1;
    }

    public boolean isSlot2() {
        return slot2;
    }

    public void setSlot2(boolean slot2) {
        this.slot2 = slot2;
    }

    public boolean isSlot3() {
        return slot3;
    }

    public void setSlot3(boolean slot3) {
        this.slot3 = slot3;
    }

    public boolean isSlot4() {
        return slot4;
    }

    public void setSlot4(boolean slot4) {
        this.slot4 = slot4;
    }

    public boolean isSlot5() {
        return slot5;
    }

    public void setSlot5(boolean slot5) {
        this.slot5 = slot5;
    }

    public boolean isSlot6() {
        return slot6;
    }

    public void setSlot6(boolean slot6) {
        this.slot6 = slot6;
    }

    public boolean isSlot7() {
        return slot7;
    }

    public void setSlot7(boolean slot7) {
        this.slot7 = slot7;
    }

    public boolean isSlot8() {
        return slot8;
    }

    public void setSlot8(boolean slot8) {
        this.slot8 = slot8;
    }

    public boolean isSlot9() {
        return slot9;
    }

    public void setSlot9(boolean slot9) {
        this.slot9 = slot9;
    }

    public boolean isSlot10() {
        return slot10;
    }

    public void setSlot10(boolean slot10) {
        this.slot10 = slot10;
    }

    public void setSlotAvailability(int slotNumber, boolean isAvailable) {
        switch (slotNumber) {
            case 1:
                setSlot1(isAvailable);
                break;
            case 2:
                setSlot2(isAvailable);
                break;
            case 3:
                setSlot3(isAvailable);
                break;
            case 4:
                setSlot4(isAvailable);
                break;
            case 5:
                setSlot5(isAvailable);
                break;
            case 6:
                setSlot6(isAvailable);
                break;
            case 7:
                setSlot7(isAvailable);
                break;
            case 8:
                setSlot8(isAvailable);
                break;
            case 9:
                setSlot9(isAvailable);
                break;
            case 10:
                setSlot10(isAvailable);
                break;
            default:
                // Handle invalid slotNumber
                break;
        }
    }

    public boolean isSlotAvailable(int slotNumber) {
        switch (slotNumber) {
            case 1:
                return slot1;
            case 2:
                return slot2;
            case 3:
                return slot3;
            case 4:
                return slot4;
            case 5:
                return slot5;
            case 6:
                return slot6;
            case 7:
                return slot7;
            case 8:
                return slot8;
            case 9:
                return slot9;
            case 10:
                return slot10;
            default:
                // Handle invalid slotNumber
                return false; // You can change this default behavior as needed
        }
    }
}

