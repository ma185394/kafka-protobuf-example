CREATE table tracked_orders.orders
(
    id uuid NOT NULL,
    tracked_order_id character varying (100) NOT NULL,
    organization character varying (64),
    tracked_order_body jsonb,
    site_id character varying (50),
    date_created timestamp without time zone
);
