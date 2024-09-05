-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'full_stack_tonerow';

DROP DATABASE full_stack_tonerow;

DROP USER tonerow_capstone_owner;
DROP USER tonerow_capstone_appuser;
